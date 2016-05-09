#ifndef FLOORPLANER_H
#define FLOORPLANER_H

#include <QWidget>
#include <QVBoxLayout>
#include <QHBoxLayout>
#include <QGridLayout>
#include <QPushButton>
#include <QTimer>
#include <QLabel>

class FloorPlaner : public QWidget
{
    Q_OBJECT

public:
    FloorPlaner(QWidget *parent = 0);
    ~FloorPlaner();
private:
    QList<QPushButton*> buttons;

private slots:
    void toHoritzontal();
    void toGrid();
};

#endif // FLOORPLANER_H
