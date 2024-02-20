package upvictoria.pm_ene_abr_2024.iti_271164.pg1u1_eq02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class MainSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private Paint paint;
    private ArrayList<ClassEntity> entities;
    private DrawThread drawThread;
    private Handler handler;
    private Object lock = new Object(); // Lock object for synchronization
    private boolean isDrawingFigure = true; // Flag for indicating whether user is drawing a figure
    private boolean isDrawingLine = false; // Flag for indicating whether user is drawing a line between figures
    private ClassEntity selectedEntity1 = null; // First selected entity for drawing line
    private ClassEntity selectedEntity2 = null; // Second selected entity for drawing line

    public MainSurfaceView(Context context) {
        super(context);
        init();
    }

    public MainSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED); // Default color
        getHolder().addCallback(this);
        entities = new ArrayList<>();
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // Surface is created, start drawing
        drawThread = new DrawThread(getHolder());
        drawThread.setRunning(true);
        drawThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // Surface size or format changed
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // Surface is destroyed, cleanup
        boolean retry = true;
        drawThread.setRunning(false);
        while (retry) {
            try {
                drawThread.join();
                retry = false;
            } catch (InterruptedException e) {
                // Retry if interrupted
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isDrawingFigure) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                final float x = event.getX();
                final float y = event.getY();
                // Synchronize access to entities list
                synchronized (lock) {
                    entities.add(new ClassEntity(x, y, 100, 100)); // Create a new ClassEntity at the touch position
                }
            }
        } else if (isDrawingLine) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                final float x = event.getX();
                final float y = event.getY();
                // Find the entity at the touch position
                selectedEntity2 = findEntityAtPosition(x, y);
                if (selectedEntity2 != null) {
                    // Connect the selected entities with a line
                    connectEntities(selectedEntity1, selectedEntity2);
                    // Reset the flags and selected entities
                    selectedEntity1 = null;
                    selectedEntity2 = null;
                    isDrawingLine = false;
                }
            }
        }
        return true;
    }

    private ClassEntity findEntityAtPosition(float x, float y) {
        // Iterate over entities and check if the touch position is inside any entity
        synchronized (lock) {
            for (ClassEntity entity : entities) {
                if (entity != null && x >= entity.x && x <= entity.x + entity.width &&
                        y >= entity.y && y <= entity.y + entity.height) {
                    return entity;
                }
            }
        }
        return null;
    }

    private void connectEntities(ClassEntity entity1, ClassEntity entity2) {
        // Connect the entities with a line
        if (entity1 != null && entity2 != null) {
            entity1.setConnected(true);
            entity2.setConnected(true);
        }
    }


    public boolean isDrawingFigure() {
        return isDrawingFigure;
    }

    public void setDrawingFigure(boolean drawingFigure) {
        isDrawingFigure = drawingFigure;
    }

    public boolean isDrawingLine() {
        return isDrawingLine;
    }

    public void setDrawingLine(boolean drawingLine) {
        isDrawingLine = drawingLine;
    }


    private class DrawThread extends Thread {
        private final SurfaceHolder surfaceHolder;
        private boolean isRunning;

        public DrawThread(SurfaceHolder surfaceHolder) {
            this.surfaceHolder = surfaceHolder;
            this.isRunning = false;
        }

        public void setRunning(boolean running) {
            this.isRunning = running;
        }

        @Override
        public void run() {
            while (isRunning) {
                Canvas canvas = null;
                try {
                    canvas = surfaceHolder.lockCanvas();
                    if (canvas != null) {
                        synchronized (surfaceHolder) {
                            drawEntities(canvas);
                        }
                    }
                } finally {
                    if (canvas != null) {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                }
            }
        }

        private void drawEntities(Canvas canvas) {
            // Clear canvas
            canvas.drawColor(Color.WHITE);

            // Create a copy of the entities list to avoid concurrent modification
            ArrayList<ClassEntity> entitiesCopy;
            synchronized (lock) {
                entitiesCopy = new ArrayList<>(entities);
            }

            // Draw each entity in the copied list
            for (ClassEntity entity : entitiesCopy) {
                if (entity != null) {
                    entity.draw(canvas, paint);
                }
            }

            // Draw connections between entities
            synchronized (lock) {
                for (ClassEntity entity : entitiesCopy) {
                    if (entity != null && entity.isConnected()) {
                        // Draw line connecting entities
                        drawLineBetweenCenters(canvas, selectedEntity1, entity);
                    }
                }
            }
        }

        private void drawLineBetweenCenters(Canvas canvas, ClassEntity entity1, ClassEntity entity2) {
            float centerX1 = entity1.x + entity1.width / 2;
            float centerY1 = entity1.y + entity1.height / 2;
            float centerX2 = entity2.x + entity2.width / 2;
            float centerY2 = entity2.y + entity2.height / 2;
            canvas.drawLine(centerX1, centerY1, centerX2, centerY2, paint);
        }
    }
}
