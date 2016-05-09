#ifndef HELLOWORLD_H
#define HELLOWORLD_H

#include <QLabel>

namespace Ui {
class helloworld;
}

class helloworld : public QLabel
{
    Q_OBJECT

public:
    explicit helloworld();

private:
    Ui::helloworld *ui;
};

#endif // HELLOWORLD_H
