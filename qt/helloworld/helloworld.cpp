#include "helloworld.h"
#include "ui_helloworld.h"

helloworld::helloworld()
{
    setText("Hello World");
    resize(300, 100);
    setAlignment(Qt::AlignCenter);
    setWindowTitle("Hello World Window");
}

