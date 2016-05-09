#include "launcher.h"
#include <iostream>

Launcher::Launcher(QWidget *parent)
    : QWidget(parent)
{
    setGeometry(150, 300, 300, 60);
    setWindowTitle("Launcher by Salman Hossain");
    setStyleSheet("background-color: black");
    setWindowOpacity(.7);
    setWindowIcon(QIcon::fromTheme("info"));

    auto layout = new QGridLayout(this);
    auto btnAll = new QPushButton("All");
    auto btnApp = new QPushButton("Applications");

    buttons << btnAll;
    buttons << btnApp;

    layout->addWidget(buttons.at(0), 0, 0);
    layout->addWidget(buttons.at(1), 1, 0);

    connect(btnAll, &QPushButton::pressed, this, &Launcher::onAllClicked);
    connect(btnApp, &QPushButton::pressed, this, &Launcher::onAppClicked);




}

Launcher::~Launcher()
{

}

void Launcher::onAllClicked()
{
    delete layout();


    auto layout = new QVBoxLayout(this);
    auto btnFirefox = new QPushButton("Firefox");
    auto btnArduino = new QPushButton("Arduino");
    auto btnTerminal = new QPushButton("Gnome-Terminal");
    auto btnBlender = new QPushButton("Blender");
    auto btnFritzing = new QPushButton("Fritzing");
    auto btnAndroid = new QPushButton("Android Studio");
    auto btnBack = new QPushButton("Back");

    QIcon icon2;
    icon2.addFile(QString::fromUtf8("~/pro/qt/launcher/arduino_small.png"), QSize(), QIcon::Normal, QIcon::On);
    btnArduino->setIcon(icon2);
    btnArduino->setIconSize(QSize(100, 100));

    layout->removeWidget(buttons[0]);
    layout->removeWidget(buttons[1]);

    buttons[0] = btnFirefox;
    buttons[1] = btnArduino;
    buttons << btnTerminal;
    buttons << btnBlender;
    buttons << btnFritzing;
    buttons << btnAndroid;
    buttons << btnBack;

    for(int i=0; i < 7; i++) {
        layout->addWidget(buttons[i], i, 0);
    }

    connect(btnFirefox, &QPushButton::pressed, this, &Launcher::onFirefoxClicked);
    connect(btnArduino, &QPushButton::pressed, this, &Launcher::onArduinoClicked);
    connect(btnTerminal, &QPushButton::pressed, this, &Launcher::onTerminalClicked);
    connect(btnBlender, &QPushButton::pressed, this, &Launcher::onBlenderClicked);
    connect(btnFritzing, &QPushButton::pressed, this, &Launcher::onFritzingClicked);
    connect(btnAndroid, &QPushButton::pressed, this, &Launcher::onAndroidClicked);
    connect(btnBack, &QPushButton::pressed, this, &Launcher::onBackClicked);

}

void Launcher::onBackClicked()
{
    delete layout();

    auto layout = new QVBoxLayout(this);
    auto btnAll = new QPushButton("All");
    auto btnApp = new QPushButton("Applications");

    layout->addWidget(btnAll);
    layout->addWidget(btnApp);

    connect(btnAll, &QPushButton::pressed, this, &Launcher::onAllClicked);
    connect(btnApp, &QPushButton::pressed, this, &Launcher::onAppClicked);

}

void Launcher::onAppClicked()
{
    delete layout();

    auto layout = new QVBoxLayout(this);
    auto btnArduino = new QPushButton("Arduino");
    auto btnBlender = new QPushButton("Blender");
    auto btnFritzing = new QPushButton("Fritzing");
    auto btnAndroid = new QPushButton("Android Studio");
    auto btnBack = new QPushButton("Back");

    layout->addWidget(btnArduino);
    layout->addWidget(btnBlender);
    layout->addWidget(btnFritzing);
    layout->addWidget(btnAndroid);
    layout->addWidget(btnBack);

    connect(btnArduino, &QPushButton::pressed, this, &Launcher::onArduinoClicked);
    connect(btnBlender, &QPushButton::pressed, this, &Launcher::onBlenderClicked);
    connect(btnFritzing, &QPushButton::pressed, this, &Launcher::onFritzingClicked);
    connect(btnAndroid, &QPushButton::pressed, this, &Launcher::onAndroidClicked);
    connect(btnBack, &QPushButton::pressed, this, &Launcher::onBackClicked);


}

void Launcher::onFirefoxClicked()
{
    system("firefox");
}

void Launcher::onArduinoClicked()
{
    system("/home/salman/desktop/arduino-1.6.7/arduino");
}

void Launcher::onTerminalClicked()
{
    system("gnome-terminal");
}

void Launcher::onBlenderClicked()
{
    system("/usr/bin/blender");
}

void Launcher::onFritzingClicked()
{
    system("~/fritzing/Fritzing");
}

void Launcher::onAndroidClicked()
{
    system("~/android-studio/bin/studio.sh");
}

