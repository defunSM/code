#include "simplelayout.h"

SimpleLayout::SimpleLayout()
{
    resize(200, 200);
    setStyleSheet("background-color: white");

    auto layout = new QVBoxLayout(this);

    for(int i =0; i<3; i++ ) {
        auto label = new QLabel("A Label");
        label->setStyleSheet("background-color: lightgrey");
        layout->addWidget(label);
    }

}

