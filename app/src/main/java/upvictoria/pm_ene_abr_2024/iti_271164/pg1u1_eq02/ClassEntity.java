package upvictoria.pm_ene_abr_2024.iti_271164.pg1u1_eq02;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

public class ClassEntity extends Entity {
    private ArrayList<ClassProperty.ClassAttribute> attributes;
    private ArrayList<ClassProperty.ClassMethod> methods;
    public ClassEntity(float x, float y, float width, float height) {
        super(x, y, width, height);
        this.attributes = new ArrayList<>();
        this.methods = new ArrayList<>();
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(x, y, x + width, y + height, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        float textX = x + width / 2;
        float textY = y + paint.getTextSize(); // Adjust for text baseline
        canvas.drawText("Class Name", textX, textY, paint);
    }

    public ArrayList<ClassProperty.ClassAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<ClassProperty.ClassAttribute> attributes) {
        this.attributes = attributes;
    }

    public ArrayList<ClassProperty.ClassMethod> getMethods() {
        return methods;
    }

    public void setMethods(ArrayList<ClassProperty.ClassMethod> methods) {
        this.methods = methods;
    }
}
