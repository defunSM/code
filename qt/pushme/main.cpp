#include "pushme.h"
#include <QApplication>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    PushMe w;
    w.show();

    return a.exec();
}
