#ifndef WIDGET_H
#define WIDGET_H

#include <QWidget>
#include <QVBoxLayout>
#include <QGridLayout>
#include <QMessageBox>
#include <QIcon>
#include <QLabel>


class Widget : public QWidget
{
    Q_OBJECT

public:
    Widget(QWidget *parent = 0);
    ~Widget();
};

#endif // WIDGET_H
