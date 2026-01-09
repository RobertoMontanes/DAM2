class Droid:
    pass

class DroidMethods:
    def greet(self):
        print("Beep Boop")
    def turn_on(self):
        print("Droid activated")
    def turn_off(self):
        print("Droid deactivated")
        
class DroidAttributes:
    def switch_on(self):
        self.power_on = True
        print("Hi! I am a droid. Can I help you?")

class DroidConstructor:
    def __init__(self, name, model, year):
        self.name = name
        self.model = model
        self.year = year
        
    def toStringFake(self):
        return f"Droid Name: {self.name}, Model: {self.model}, Year: {self.year}"

class DroidToString:
    def __init__(self, name, model, year):
        self.name = name
        self.model = model
        self.year = year
        
    def __init__(self):
        pass
    
    def __str__(self):
        return f"Droid Name: {self.name}, Model: {self.model}, Year: {self.year}"

r2d2 = Droid()

c3po = DroidMethods()

c3po.greet()
c3po.turn_on()
c3po.turn_off()

bb8 = DroidAttributes()
bb8.switch_on()
print(bb8)

r5d4 = DroidConstructor("R5-D4", "Astromech", 1977)
print(r5d4)

bd1 = DroidToString()
print(bd1)

r4p = DroidToString("R4-P0", "Astromech", 2002)
print(r4p)