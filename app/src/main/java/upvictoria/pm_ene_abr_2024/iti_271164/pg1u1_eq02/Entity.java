package upvictoria.pm_ene_abr_2024.iti_271164.pg1u1_eq02;

import android.graphics.Canvas;
import android.graphics.Paint;

abstract public class Entity {
    float x;
    float y;
    float width;
    float height;
    private boolean connected;

    public Entity(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    abstract void draw(Canvas canvas, Paint paint);

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }
}
