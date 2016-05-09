#include "floorplan.h"

Floorplan::Floorplan(QWidget *parent)
    : QWidget(parent)
{
    setWindowTitle("FloorPlan");
    resize(200, 300);

    auto layout = new QVBoxLayout;

    for(int i=0; i<4; i++) {
        auto label = new QLabel("Label");
        label->setStyleSheet("background-color: lightgrey");
        label->setAlignment(Qt::AlignCenter);
        labels << label;
        layout->addWidget(label);
    }
}

Floorplan::~Floorplan()
{

}
