#!/usr/bin/env python
import gtk, sys, os

mynumber="5555555555"
calnum=0
fakenum=0

def press(widget):
	num = entry.get_text()
	pnum = widget.get_label()
	entry.set_text(num + pnum)

def send_press(widget):
	print("Dialing: " + entry.get_text())

def add_call(widget):
	callnum = entry.get_text()
	entry.set_text("")

def add_fake(widget):
	fakenum = entry.get_text()
	entry.set_text("")

win = gtk.Window()
win.connect('destroy', lambda w: gtk.main_quit())

box = gtk.VBox()
win.add(box)

entry = gtk.Entry()
box.pack_start(entry, False)

table = gtk.Table(2,2, gtk.TRUE)

a = [1,2,3,4,5,6,7,8,9,"#",0,"*"]
x = 0
y = 0

for i in a:
	button = gtk.Button(str(i))
	button.connect("clicked", press)
	table.attach(button, x, x+1, y, y+1)

	x+=1
	if x > 2:
		x=0
		y+=1

box.pack_start(table)

box2 = gtk.HBox()
box.pack_start(box2)
call_button = gtk.Button("Add Call#")
call_button.connect("clicked", add_call)
box2.pack_start(call_button)

fakebutton = gtk.Button("Add Fake#")
fakebutton.connect("clicked", add_fake)
box2.pack_start(fakebutton)

send = gtk.Button("SEND")
send.connect("clicked", send_press)
box.pack_start(send)

win.show_all()

gtk.main()