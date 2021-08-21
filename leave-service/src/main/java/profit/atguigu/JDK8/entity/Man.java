package profit.atguigu.JDK8.entity;

import java.util.Objects;

public class Man {
    private Godness godness;

    public Man() {
    }

    public Man(Godness godness) {
        this.godness = godness;
    }

    public Godness getGodness() {
        return godness;
    }

    public void setGodness(Godness godness) {
        this.godness = godness;
    }

    @Override
    public String toString() {
        return "Man{" + "godness=" + godness + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Man man = (Man) o;
        return Objects.equals(godness, man.godness);
    }

    @Override
    public int hashCode() {

        return Objects.hash(godness);
    }
}
