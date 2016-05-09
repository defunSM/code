#include "exampleproject.h"
#include <QApplication>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    ExampleProject w;
    w.show();

    return a.exec();
}
