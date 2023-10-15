public class Square extends Rectangle {

    public Square(double side) {
        super(side, side);
    }

    /**
     * create a square.
     *
     * @param color  mau.
     * @param filled sai.
     * @param side   do dai canh.
     */
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return super.length;
    }

    public void setSide(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    public Square() {

    }

    @Override
    public String toString() {
        return "Square[side=" + this.getLength() + ",color="
                + this.getColor() + ",filled=" + this.isFilled() + "]";
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setLength(double side) {
        super.setLength(side);
        super.setWidth(side);
    }
}
