#include "simplelayout.h"
#include <QApplication>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    SimpleLayout w;
    w.show();

    return a.exec();
}
