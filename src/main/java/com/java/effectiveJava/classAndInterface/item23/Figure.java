package com.java.effectiveJava.classAndInterface.item23;

abstract class Figure {
    abstract double area();
}

class Circle extends Figure{
    final double radius;

    Circle(double radius){this.radius = radius;}


    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}

class Rectangle extends Figure{
    final double length;
    final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}
