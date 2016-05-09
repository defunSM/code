#ifndef POPUPS_H
#define POPUPS_H

#include <QMessageBox>
#include <QPushButton>

#include <QtWidgets>

class Popups : public QWidget
{
    Q_OBJECT

public:
    Popups();

private slots:
    void onInfoClicked();
    void onQuitClicked();

};

#endif // POPUPS_H
