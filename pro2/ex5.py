import pygame
import os, sys
import random 
import time



class Player(object):
    def __init__(self, name, items, stats, location):
        self.name = name
        self.items = items
        self.stats = stats
        self.location = location

    def display_hp(self):
        print self.stats['hp']

    def printlocation(self):
        print self.location

    def printname(self):
        print self.name

    def printitems(self):
        for item in items:
            print item

    def addstat(self, stat_name, value):
        self.stats[stat_name] += value

    def additem(self, item_name, value):
        self.items[item_name] += value 

items = {}
stats = {}
location = (0,0)
person = ("unknown", items, stats, location)


class SceneBase:
    def __init__(self):
        self.next = self
    
    def ProcessInput(self, events, pressed_keys, screen, player, token):
        print("uh-oh, you didn't override this in the child class")

    def Update(self):
        print("uh-oh, you didn't override this in the child class")

    def Render(self, screen):
        print("uh-oh, you didn't override this in the child class")

    def SwitchToScene(self, next_scene):
        self.next = next_scene
    
    def Terminate(self):
        self.SwitchToScene(None)

def run_game(width, height, fps, starting_scene, player, token):



    pygame.init()
    screen = pygame.display.set_mode((width, height))
    clock = pygame.time.Clock()

    active_scene = starting_scene

    while active_scene != None:
        pressed_keys = pygame.key.get_pressed()
        
        # Event filtering
        filtered_events = []
        for event in pygame.event.get():
            quit_attempt = False
            if event.type == pygame.QUIT:
                quit_attempt = True
            elif event.type == pygame.KEYDOWN:
                alt_pressed = pressed_keys[pygame.K_LALT] or \
                              pressed_keys[pygame.K_RALT]
                if event.key == pygame.K_ESCAPE:
                    quit_attempt = True
                elif event.key == pygame.K_F4 and alt_pressed:
                    quit_attempt = True
            
            if quit_attempt:
                active_scene.Terminate()
            else:
                filtered_events.append(event)
        
        
        active_scene.Update()
        active_scene.Render(screen)
        active_scene.ProcessInput(filtered_events, pressed_keys, screen, player, token)
        

        active_scene = active_scene.next
        
        pygame.display.flip()
        clock.tick(fps)

# The rest is code where you implement your game using the Scenes model

class TitleScene(SceneBase):
    def __init__(self):
        SceneBase.__init__(self)

    
    def ProcessInput(self, events, pressed_keys, screen, player, token):
        m = pygame.mouse.get_pos()
        mk = pygame.mouse.get_pressed()

        def create_text(size, color, location_x, location_y, texts):
    
            font = pygame.font.SysFont("comicsansms", size)
            text1 = font.render(texts, True, color)
            screen.blit(text1, (location_x, location_y))

        if m[0] > 350 and m[0] < 400 and m[1] > 1 and m[1] < 10:
            words = "Alpha 1.00a"
            create_text(8, (230,255,0), 350, 1, words)
        else:
            words = "Alpha 1.00a"
            create_text(8, (0,0,0), 350, 1, words)
    

        if m[0] > 158 and m[0] < 229 and m[1] > 153 and m[1] < 168 and mk[0] == 1:
            print "[Game] You have clicked to enter Menu."
            self.SwitchToScene(GameScene())
        
        if m[0] > 158 and m[0] < 229 and m[1] > 153 and m[1] < 168:

            font = pygame.font.SysFont("comicsansms", 12)
            text = font.render("Press Enter", True, (230, 255, 0))
            screen.blit(text, (161, 150))
        else:

            font = pygame.font.SysFont("comicsansms", 12)
            text = font.render("Press Enter", True, (0, 0, 0))
            screen.blit(text, (161, 150))
           
        for event in events:
            if event.type == pygame.KEYDOWN and event.key == pygame.K_RETURN:
                print "[Game] You have entered the Menu."
                
                self.SwitchToScene(GameScene())


        if m[0] > 158 and m[0] < 229 and m[1] > 153 and m[1] < 168:

            pygame.time.wait(100)
            location_x = random.randrange(150, 240)
            location_y = random.randrange(145, 180)

            radius = random.randrange(2,4)
            pygame.draw.circle(screen, (162,0,255), (location_x, location_y), radius)

        else:
            pass

        

        
    
    def Update(self):
        pass
        
    
    def Render(self, screen):
        # For the sake of brevity, the title scene is a blank red screen
        
        img = pygame.image.load('onemorelinetitle.png')
        screen.blit(img, (0, 0))
        screen.blit(pygame.image.load('onelife.png'), (120, 20))
        screen.blit(pygame.image.load('copyrightinfo.png'), (245,284))


class GameScene(SceneBase):
    def __init__(self):
        SceneBase.__init__(self)
    
    def ProcessInput(self, events, pressed_keys, screen, player, token):

        m = pygame.mouse.get_pos()
        mk = pygame.mouse.get_pressed()
        



        if m[0] > 158 and m[0] < 229 and m[1] > 153 and m[1] < 168:
            font = pygame.font.SysFont("comicsansms", 12)
            text = font.render("Start Game", True, (230, 255, 0))
            screen.blit(text, (161, 150))

            font = pygame.font.SysFont("comicsansms", 12)
            text = font.render("Instructions", True, (0, 0, 0))
            screen.blit(text, (159, 200))

            

        elif m[0] > 158 and m[0] < 230 and m[1] > 203 and m[1] < 216:
            font = pygame.font.SysFont("comicsansms", 12)
            text = font.render("Instructions", True, (230, 255, 0))
            screen.blit(text, (159, 200))

            font = pygame.font.SysFont("comicsansms", 12)
            text = font.render("Start Game", True, (0, 0, 0))
            screen.blit(text, (161, 150))

            

        else:
            font = pygame.font.SysFont("comicsansms", 12)
            text = font.render("Start Game", True, (0, 0, 0))
            screen.blit(text, (161, 150))


            font = pygame.font.SysFont("comicsansms", 12)
            text = font.render("Instructions", True, (0, 0, 0))
            screen.blit(text, (159, 200))

            """Testing Area
            pygame.time.wait(300)

            radius = random.randrange(2,4)
            if mk[0] == 0:
                pygame.draw.circle(screen,(162, 0, 225), (100, 100), radius)
            elif mk[0] == 1:
                pygame.draw.circle(screen,(0, 0, 255), (100, 100), radius)
                b1 = 1
            elif b1 == 1:
                pass
            else:
                pass
            if b1 == 1:
                pygame.draw.circle(screen,(0, 0, 255), (100, 100), radius)
            

            pygame.draw.circle(screen,(162, 0, 225), (110, 125), radius)
            pygame.draw.circle(screen,(162, 0, 225), (270, 240), radius)

            Testing Area"""

            

        if m[0] > 158 and m[0] < 230 and m[1] > 203 and m[1] < 216:
            pygame.time.wait(100)
            location_x = random.randrange(150, 240)
            location_y = random.randrange(213, 223)

            radius = random.randrange(2,4)
            pygame.draw.circle(screen, (162,0,255), (location_x, location_y), radius)
        else:
            pass


    
        if m[0] > 158 and m[0] < 229 and m[1] > 153 and m[1] < 168:

            pygame.time.wait(100)
            location_x = random.randrange(150, 240)
            location_y = random.randrange(145, 180)

            radius = random.randrange(2,4)
            pygame.draw.circle(screen, (162,0,255), (location_x, location_y), radius)

        else:
            pass

        for event in events:
            if event.type == pygame.KEYDOWN and event.key == pygame.K_RETURN and m[0] > 158 and m[0] < 230 and m[1] > 203 and m[1] < 216:
                print "[Game] You have entered Instructions."
                self.SwitchToScene(Intro())

        if m[0] > 158 and m[0] < 230 and m[1] > 203 and m[1] < 216 and mk[0] == 1:
            print "[Game] You have clicked on Instructions."
            self.SwitchToScene(Intro())
        
    def Update(self):
        pass
    
    def Render(self, screen):
        # The game scene is just a blank blue screen
        img = pygame.image.load('onemorelinetitle.png')
        screen.blit(img, (0, 0))
        screen.blit(pygame.image.load('onelife.png'), (120, 20))
        screen.blit(pygame.image.load('copyrightinfo.png'), (245,284))


class Intro(SceneBase):
    def __init__(self):
        self.next = self
    
    def ProcessInput(self, events, pressed_keys, screen, player, token):
        m = pygame.mouse.get_pos()
        mk = pygame.mouse.get_pressed()
        
        def create_text(size, color, location_x, location_y, texts):
    
            font = pygame.font.SysFont("comicsansms", size)
            text1 = font.render(texts, True, color)
            screen.blit(text1, (location_x, location_y))

        
        words = "I don't know why you would need instructions to this game but okay ..."
        create_text(10, (0,0,0), 1, 30, words)
        words = "This is the game interface where words appear should be simple enough."
        create_text(10, (0,0,0), 1, 40, words)
        words = "When you see 'Press Enter to Continue' on the bottom you can do two things. "
        create_text(10, (0,0,0), 1, 80, words)
        words = "One. If you really like seeing the purple dot flying around you can click on it."
        create_text(10, (0,0,0), 1, 90, words)
        words = "Or Two. You can simply press enter."
        create_text(10, (0,0,0), 1, 100, words)
        
        if m[0] > 155 and m[0] < 162 and m[1] < 270 and m[1] > 261:
            words = "Press Enter to Continue . . ."
            create_text(10, (230,255,0), 250, 250, words)

        else:
            words = "Press Enter to Continue . . ."
            create_text(10, (0,0,0), 250, 250, words)

        words = "There should be something else you might want to know is that I lie. A lot."
        create_text(10, (0,0,0), 1, 140, words)
        words = "So how do you actually continue? Find the purple dot. HINT: Move Mouse."
        create_text(10, (0,0,0), 1, 180, words)


        if m[0] > 155 and m[0] < 162 and m[1] < 270 and m[1] > 261 and mk[0] == 1:
            print "[Game] You have proceeded to the next screen for instructions."
            self.SwitchToScene(Intro1())

        elif m[0] > 155 and m[0] < 162 and m[1] < 270 and m[1] > 261:
            pygame.time.wait(100)
            location_x = random.randrange(155, 162)
            location_y = random.randrange(261, 270)

            radius = random.randrange(2,4)
            pygame.draw.circle(screen, (162,0,255), (location_x, location_y), radius)
        
        
        else:
            pass
                

        for event in events:
            if event.type == pygame.KEYDOWN and event.key == pygame.K_RETURN and m[0] > 155 and m[0] < 162 and m[1] < 270 and m[1] > 261:
                print "[Game] You have proceeded to the next screen for instructions."
                self.SwitchToScene(Intro1())


    def Update(self):
        pass

    def Render(self, screen):
        
        screen.blit(pygame.image.load('onemorelinetitle.png'), (0, 0))
        screen.blit(pygame.image.load('copyrightinfo.png'), (245,284))

        


class Intro1(SceneBase):
    def __init__(self):
        self.next = self
    
    def ProcessInput(self, events, pressed_keys, screen, player, token):
        m = pygame.mouse.get_pos()
        mk = pygame.mouse.get_pressed()

        print m

        def create_text(size, color, location_x, location_y, texts):
    
            font = pygame.font.SysFont("comicsansms", size)
            text1 = font.render(texts, True, color)
            screen.blit(text1, (location_x, location_y))


        words = "Good Job. You know how to move a mouse and left click."
        create_text(10, (0,0,0), 1, 30, words)
        words = "If you found that difficult you should probably quit."
        create_text(10, (0,0,0), 1, 40, words)
        words = "Now. Lets talk more about that purple dot. What is it? "
        create_text(10, (0,0,0), 1, 80, words)
        words = "The purple dot shows that an interaction is avaliable."
        create_text(10, (0,0,0), 1, 90, words)
        words = "Try hovering your mouse over the image on the right."
        create_text(10, (0,0,0), 1, 100, words)
        words = "Press Enter to Continue . . ."
        create_text(10, (0,0,0), 250, 250, words)


        if m[0] > 309 and m[0] < 370 and m[1] > 109 and m[1] < 172 and mk[0] == 1:
            print "[Game] You are advancing to the next screen."
            self.SwitchToScene(Intro2())

        elif m[0] > 309 and m[0] < 370 and m[1] > 109 and m[1] < 172:

            words = "Click on the apple to continue to the next screen."
            create_text(10, (0,0,0), 1, 140, words)

            words = "Press Enter to Continue . . ."
            create_text(10, (230,255,0), 250, 250, words)

            pygame.time.wait(100)
            location_x = random.randrange(309,370)
            location_y = random.randrange(109,172)

            radius = random.randrange(2,4)
            pygame.draw.circle(screen, (162,0,255), (location_x, location_y), radius)

        else:
            pass

        

        for event in events:
            if event.type == pygame.KEYDOWN and event.key == pygame.K_RETURN and m[0] > 309 and m[0] < 370 and m[1] > 109 and m[1] < 172:
                print "[Game] You are advancing to the next screen."
                self.SwitchToScene(Intro2())


    def Update(self):
        pass

    def Render(self, screen):
        
        screen.blit(pygame.image.load('onemorelinetitle.png'), (0, 0))
        screen.blit(pygame.image.load('copyrightinfo.png'), (245,284))
        screen.blit(pygame.image.load('apple_1.png'), (300, 100))

class Intro2(SceneBase):
    def __init__(self):
        self.next = self
    
    def ProcessInput(self, events, pressed_keys, screen, player, token):
        m = pygame.mouse.get_pos()
        mk = pygame.mouse.get_pressed()

        def create_text(size, color, location_x, location_y, texts):
    
            font = pygame.font.SysFont("comicsansms", size)
            text1 = font.render(texts, True, color)
            screen.blit(text1, (location_x, location_y))

        words = "You made it this far so lets keep going."
        create_text(10, (0,0,0), 1, 30, words)
        words = "Right now you know of a singular interaction the purple dot."
        create_text(10, (0,0,0), 1, 40, words)
        words = "There are other colors that represent multi interactions."
        create_text(10, (0,0,0), 1, 80, words)
        words = "You can also choose what action you want to perform."
        create_text(10, (0,0,0), 1, 90, words)
        words = "This can be done by pressing the up and down button."
        create_text(10, (0,0,0), 1, 100, words)
        words = "Press Enter to Continue . . ."
        create_text(10, (0,0,0), 250, 250, words)

        print mk

        if m[0] > 150 and m[1] > 150 and m[1] < 206 and m[0] < 206:
            words = "Open Bag"
            create_text(10, (230,250,0), m[0] - 60 , m[1] - 20, words)

            if mk[0] == 1:
                cycle1()


        def cycle1():
            
            if m[0] > 150 and m[1] > 150 and m[1] < 206 and m[0] < 206:
                words = "Take Chicken"
                create_text(10, (230,250,0), m[0] - 60 , m[1] - 40, words)
                words = "Take Fries"
                create_text(10, (0,0,0), m[0] - 60 , m[1] - 30, words)
                words = "Take CheeseBurger"
                create_text(10, (0,0,0), m[0] - 60 , m[1] - 20, words)
                screen.blit(pygame.image.load('chicken.png'), (m[0] - 60,m[1] - 60))
                cycle1()
                if mk[2] == 1:
                    cycle2()

            else:
                pass

        def cycle2():

            if m[0] > 150 and m[1] > 150 and m[1] < 206 and m[0] < 206:
                words = "Take Chicken"
                create_text(10, (0,2,0), m[0] - 60 , m[1] - 40, words)
                words = "Take Fries"
                create_text(10, (230,250,0), m[0] - 60 , m[1] - 30, words)
                words = "Take CheeseBurger"
                create_text(10, (0,0,0), m[0] - 60 , m[1] - 20, words)
                screen.blit(pygame.image.load('chicken.png'), (m[0] - 60,m[1] - 60))
                cycle2()
                if mk[2] == 1:
                    cycle3()
            else:
                pass

            def cycle3():

                if m[0] > 150 and m[1] > 150 and m[1] < 206 and m[0] < 206:
                    words = "Take Chicken"
                    create_text(10, (0,2,0), m[0] - 60 , m[1] - 40, words)
                    words = "Take Fries"
                    create_text(10, (0,0,0), m[0] - 60 , m[1] - 30, words)
                    words = "Take CheeseBurger"
                    create_text(10, (230,250,0), m[0] - 60 , m[1] - 20, words)
                    screen.blit(pygame.image.load('chicken.png'), (m[0] - 60,m[1] - 60))
                    cycle3()
                    if mk[2] == 1:
                        cycle1()
                else:
                    pass







    def Update(self):
        pass

    def Render(self, screen):
        
        screen.blit(pygame.image.load('onemorelinetitle.png'), (0, 0))
        screen.blit(pygame.image.load('copyrightinfo.png'), (245,284))
        screen.blit(pygame.image.load('bookbag.png'), (150,150))



class Intro3(SceneBase):
    def __init__(self):
        self.next = self
    
    def ProcessInput(self, events, pressed_keys, screen, player, token):
        m = pygame.mouse.get_pos()
        mk = pygame.mouse.get_pressed()

        def create_text(size, color, location_x, location_y, texts):
    
            font = pygame.font.SysFont("comicsansms", size)
            text1 = font.render(texts, True, color)
            screen.blit(text1, (location_x, location_y))
        

        for event in events:
            if event.type == pygame.KEYDOWN and event.key == pygame.K_RETURN:
                # Move to the next scene when the user pressed Enter
                self.SwitchToScene()


    def Update(self):
        pass

    def Render(self, screen):
        
        screen.blit(pygame.image.load('onemorelinetitle.png'), (0, 0))
        screen.blit(pygame.image.load('copyrightinfo.png'), (245,284))

run_game(400, 300, 60, TitleScene(), person, 0)