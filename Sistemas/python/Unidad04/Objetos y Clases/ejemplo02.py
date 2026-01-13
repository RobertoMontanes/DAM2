class MobilePhone:
    
    @staticmethod
    def decorator(function):
        def wrapper(self,*args, **kwargs):
            print(f'Ejecuntando: {function.__name__}')
            return function(self,*args, **kwargs)
        return wrapper
    
    def __init__(self, manufacturer: str, screen_size: float, num_cores: int, apps: list[str]):
        self.manufacturer = manufacturer
        self.screen_size = screen_size
        self.num_cores = num_cores
        self.apps = apps
        self.status = False;
        
    @decorator
    def power_on(self):
        if self.status:
            return False
        self.status = True
    
    @decorator
    def power_off(self):
        if not self.status:
            return False
        self.status = False
        
    @decorator
    def install_app(self, app_name: str | list[str]):
        if isinstance(app_name, list[str]):
            for app in app_name:
                if app not in self.apps:
                    self.apps.append(app)
        else:
            if app_name not in self.apps:
                self.apps.append(app_name)
        
    @decorator
    def uninstall_app(self, app_name: str):
        if app_name in self.apps:
            self.apps.remove(app_name)
