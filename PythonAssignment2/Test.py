import math


class CircleComp:
    def __init__(self, radius):
        self.radius = radius
        self.diameter = self.calculate_diameter()
        self.circumference = self.calculate_circumference()
        self.area = self.calculate_area()

    def calculate_diameter(self):
        return 2.0 * self.radius

    def calculate_circumference(self):
        return 2.0 * math.pi * self.radius

    def calculate_area(self):
        return math.pi * (self.radius ** 2)

    def display_results(self):
        print(f"Radius: {self.radius}")
        print(f"Diameter: {self.diameter}")
        print(f"circumference : {self.circumference}")
        print(f"area :{self.area}")

radius_value = float(input("Enter the radius of the circle :"))
circle = CircleComp(radius_value)
circle.display_results()