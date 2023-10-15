public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle() {

    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Creates a new Rectangle.
     *
     * @param color  mau sac.
     * @param filled sai.
     * @param width  do dai.
     * @param length chieu rong.
     */
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    /**
     * tinh chu vi.
     *
     * @return chu vi.
     */
    @Override
    public double getArea() {
        return this.getLength() * this.width;
    }

    /**
     * tinh dien tich.
     *
     * @return chu vi.
     */
    @Override
    public double getPerimeter() {
        return 2 * (this.getLength() + this.getWidth());
    }

    @Override
    public String toString() {
        return "Rectangle[width=" + this.getWidth() + ",length="
                + this.getLength() + ",color=" + this.getColor()
                + ",filled=" + this.isFilled() + "]";
    }
}
