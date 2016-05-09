#include "popups.h"

Popups::Popups()
{
    resize(500, 200);
    setWindowIcon(QIcon::fromTheme("info"));
    setWindowTitle("Information MessageBox");

    auto layout = new QVBoxLayout(this);
    auto btnInfo = new QPushButton("Info");
    auto btnQuit = new QPushButton("Quit");
    layout->addWidget(btnInfo);
    layout->addWidget(btnQuit);

    connect(btnInfo, &QPushButton::clicked, this, &Popups::onInfoClicked);
    connect(btnQuit, &QPushButton::clicked, this, &Popups::onQuitClicked);
}

void Popups::onInfoClicked()
{
    QMessageBox::information(this, "info", "just so you know...");
}

void Popups::onQuitClicked()
{
    QMessageBox::information(this, "Quit", "You are trying to quit.");
}

