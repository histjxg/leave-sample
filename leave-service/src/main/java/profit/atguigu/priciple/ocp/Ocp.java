package profit.atguigu.priciple.ocp;

public class Ocp {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawCircle(new Circle());
        graphicEditor.drawRectangle(new Rectangle());
        graphicEditor.drawTriangle(new Triangle());
    }
}

class GraphicEditor{
    public void drawShape(Shape shape){
        if(shape.m_type==1){
            drawRectangle(shape);
        }else if(shape.m_type==2){
            drawCircle(shape);
        }else if(shape.m_type==3){
            drawTriangle(shape);
        }
    }

    public void drawRectangle(Shape r){
        System.out.println("绘制矩形");
    }
    public void drawCircle(Shape r){
        System.out.println("绘制圆形");
    }
    public void drawTriangle(Shape r){
        System.out.println("绘制三角形");
    }
}
//是基类
class Shape{
    int m_type;
}

class Rectangle extends Shape{
    Rectangle(){
        super.m_type = 1;
    }
}
class Circle extends Shape{
    Circle(){
        super.m_type=2;
    }
}
//新增三角形
class Triangle extends Shape{
    Triangle(){
        super.m_type=3;
    }
}
