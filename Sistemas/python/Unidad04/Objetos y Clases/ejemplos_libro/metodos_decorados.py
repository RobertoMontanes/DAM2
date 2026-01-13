class Droid:
    @staticmethod
    def audit(method):
        def wrapper(self, *args, **kwargs):
            print(f"Droid {self.name} is running {method.__name__}")
            return(method(self, *args, **kwargs))
        return wrapper
    
    def __init__(self, name: str):
        self.name = name
        self.pos = [0,0]
        
    @audit
    def move(self, pos: tuple[int,int]):
        self.pos[0] += pos[0]
        self.pos[1] += pos[1]
        
    @audit
    def reset(self):
        self.pos = [0,0]
        

droid = Droid('B1')
droid.move(1,1)
droid.reset()