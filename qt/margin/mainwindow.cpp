#include "mainwindow.h"

MainWindow::MainWindow(QWidget *parent)
    : QWidget(parent)
{
    setWindowTitle("Margin");

    auto layout = new QVBoxLayout(this);

    for(int i=0; i<2; i++) {
        auto label = new QLabel("Label");
        label->setAlignment(Qt::AlignCenter);
        label->setStyleSheet("background-color: lightgrey");
        label->setMinimumSize(200, 50);
        layout->addWidget(label);

    }

    toWideSpacing();
}

MainWindow::~MainWindow()
{

}

void MainWindow::toWideSpacing()
{
    layout()->setSpacing(100);
}
