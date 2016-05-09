#!/usr/bin/perl -w
use strict;
use warnings;
use Text::ParseWords;

$|=1;

sub main {
    my $file = '/root/time.txt';

    open(INPUT, $file) or die "Input file $file not found\n";

    while(my $line = <INPUT>) {
        if($line =~ /\d+/) {
            print $line;
        }
    }

    close(INPUT);
}

sub wordcount {
    my $file = '/root/time.txt';

    open(INPUT, $file) or die "Input file $file not found\n";

    while (my $line = <INPUT>) {
        if($line =~ /\d+/) {
            print $line;
        }
    }



    close(INPUT);
}

wordcount();
