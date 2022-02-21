import java.lang.reflect.Array;

public class Land {

    private String terrain = "forrest";
    private int x,y;
    private int size;

    public String getTerrain() {
        return terrain;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Land{" +
                "terrain='" + terrain + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", size=" + size +
                '}';
    }


}
