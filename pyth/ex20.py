#!/usr/bin/env python

import Tkinter
import tkMessageBox
import graphics
import sys
import os

win = Tkinter.Tk()
win.title('Promethus 2')
win.geometry('300x400')

frame = Tkinter.Frame(win)
frame.pack(side = Tkinter.LEFT)

frame2 = Tkinter.Frame(win)
frame.pack(side = Tkinter.RIGHT)

textbox = Tkinter.Text(frame, height=200, width=400)
textbox.pack()

win.mainloop()


