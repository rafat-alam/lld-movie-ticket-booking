import java.util.Objects;

public class Date {
    int d, m, y;

    Date(int d, int m, int y) {
        this.d = d;
        this.m = m;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date date)) return false;
        return d == date.d && m == date.m && y == date.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(d, m, y);
    }
}
