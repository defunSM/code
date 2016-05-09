#include "floorplaner.h"

FloorPlaner::FloorPlaner(QWidget *parent)
    : QWidget(parent)
{
    resize(300, 200);
    setWindowTitle("FloorPlanner");

    auto layout = new QVBoxLayout(this);

    for(int i=0; i<4; i++) {

        auto label = new QPushButton("Label");
        label->setStyleSheet("background-color: lightgrey");
        buttons << label;

        layout->addWidget(buttons[i]);
    }

    toGrid();
}

FloorPlaner::~FloorPlaner()
{

}

void FloorPlaner::toHoritzontal()
{
    delete layout();
    auto layout = new QHBoxLayout(this);

    foreach(QPushButton* label, buttons) {
        layout->addWidget(label);
    }

}

void FloorPlaner::toGrid()
{
    delete layout();
    auto layout = new QGridLayout(this);

    for(int i=0; i < 4; i++) {
        layout->addWidget(buttons[i], i, 0);
    }



}
