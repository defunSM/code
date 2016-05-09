#ifndef TIMER_H
#define TIMER_H

#include <QWidget>
#include <QMessageBox>
#include <QVBoxLayout>
#include <QPushButton>
#include <QLabel>
#include <QTimer>
#include <QIcon>


class Timer : public QWidget
{
    Q_OBJECT

public:
    Timer(QWidget *parent = 0);
    ~Timer();

private slots:
    void onTimeout();

};

#endif // TIMER_H
