#ifndef PUSHME_H
#define PUSHME_H

#include <QPushButton>
#include <QMessageBox>

#include <QWidget>

namespace Ui {
class PushMe;
}

class PushMe : public QPushButton
{
    Q_OBJECT

public:
    explicit PushMe();

private slots:
    void onClicked();

};

#endif // PUSHME_H
