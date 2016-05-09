#include "floorplan.h"
#include <QApplication>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    Floorplan w;
    w.show();

    return a.exec();
}
