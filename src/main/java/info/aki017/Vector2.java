package info.aki017;

public class Vector2 {
    public int x;
    public int y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 rotate(int rotation) {

        Vector2 v = new Vector2(0, 0);
        switch (rotation) {
            case 0:
                v.x = this.x;
                v.y = this.y;
                break;
            case 90:
                v.x = this.y;
                v.y = -this.x;
                break;
            case 180:
                v.x = -this.x;
                v.y = -this.y;
                break;

            case 270:
                v.x = -this.y;
                v.y = this.x;
                break;
        }

        return v;
    }
}
