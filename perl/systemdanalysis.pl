#!/usr/bin/perl -w
use strict;
use warnings;

sleep 8;
system("emacs &");
sleep 5;
system("umount /dev/mmcblk0p1");
sleep 1;
system("mount /dev/mmcblk0p1 /mnt");
sleep 1;
system("mount -o remount,rw '/mnt'");

sleep 80;
system("systemd-analyze time >> time.txt");
