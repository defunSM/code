#include "timer.h"

Timer::Timer(QWidget *parent)
    : QWidget(parent)
{
    resize(200,200);
    setWindowTitle("Timer");
    setWindowIcon(QIcon::fromTheme("time"));

    auto layout = new QVBoxLayout(this);
    auto label = new QLabel("        This is some text");
    auto btnStart = new QPushButton("Start");
    auto timer = new QTimer(this);
    timer->setSingleShot(true);


    layout->addWidget(label);
    layout->addWidget(btnStart);

    connect(timer, &QTimer::timeout, this, &Timer::onTimeout);

    timer->start(5000);

}

Timer::~Timer()
{

}

void Timer::onTimeout()
{

}
