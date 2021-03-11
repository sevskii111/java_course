package ru.novsu.povt.svv.graphics;

public class Background extends Graph {
    private Texture texture = Texture.None;

    public Background() {
    }

    public Background(Color color) {
        this.color = color;
    }

    public Background(Texture texture) {
        this.texture = texture;
    }

    public Background(Color color, Texture texture) {
        this.color = color;
        this.texture = texture;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    @Override public void draw() {
        System.out.println(String.format("Фон: текстура %s, цвет %s", texture, color));
    }

}
