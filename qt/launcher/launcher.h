#ifndef LAUNCHER_H
#define LAUNCHER_H

#include <QWidget>
#include <QMessageBox>
#include <QVBoxLayout>
#include <QHBoxLayout>
#include <QGridLayout>
#include <QPushButton>
#include <QLabel>

class Launcher : public QWidget
{
    Q_OBJECT

public:
    Launcher(QWidget *parent = 0);
    ~Launcher();

private:
    QList<QPushButton*> buttons;

private slots:
    void onFirefoxClicked();
    void onArduinoClicked();
    void onTerminalClicked();
    void onBlenderClicked();
    void onFritzingClicked();
    void onAndroidClicked();
    void onAllClicked();
    void onAppClicked();
    void onBackClicked();
};

#endif // LAUNCHER_H
