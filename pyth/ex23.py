#!/usr/bin/env python
import dbus, sys, os

bus = dbus.SystemBus()

call = dbus.Interface(bus.get_object('com.nokia.csd',
	'/com/nokia/csd/call'), 
	'/com.nokia.csd.Call')

call.CreateWith("18004664411", dbus.UInt32(0))