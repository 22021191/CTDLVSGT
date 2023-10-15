public class Circle extends Shape {
    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * khoi tao.
     *
     * @param radius ban kinh.
     * @param color  mau.
     * @param filled dung sai.
     */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    /**
     * tinh dien tich.
     *
     * @return dien tich.
     */
    @Override
    public double getArea() {

        return Math.PI * radius * radius;
    }

    /**
     * tinh dien tich.
     *
     * @return chu vi.
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle[radius=" + this.getRadius() + ",color="
                + this.getColor() + ",filled=" + this.isFilled() + "]";
    }

}
