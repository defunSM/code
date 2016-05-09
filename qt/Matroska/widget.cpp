#include "widget.h"

Widget::Widget(QWidget *parent)
    : QWidget(parent)
{
    setWindowTitle("Matroska");
    setWindowIcon(QIcon::fromTheme("face-angel"));
    setGeometry(1200, 300, 300, 200);
}

Widget::~Widget()
{

}
