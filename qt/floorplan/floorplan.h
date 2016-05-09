#ifndef FLOORPLAN_H
#define FLOORPLAN_H


#include <QVBoxLayout>
#include <QHBoxLayout>
#include <QGridLayout>
#include <QLabel>
#include <QTimer>
#include <QMessageBox>
#include <QPushButton>

class Floorplan : public QWidget
{
    Q_OBJECT

public:
    Floorplan(QWidget *parent = 0);
    ~Floorplan();

private:
    QList<QLabel*> labels;

private slots:
};

#endif // FLOORPLAN_H
