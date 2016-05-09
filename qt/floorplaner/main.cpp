#include "floorplaner.h"
#include <QApplication>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    FloorPlaner w;
    w.show();

    return a.exec();
}
