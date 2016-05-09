#include "exampleproject.h"

ExampleProject::ExampleProject(QWidget *parent)
    : QWidget(parent)
{
    setWindowTitle("ExampleProject");
    resize(200,200);
    setGeometry(500,500,500,500);
    setWindowIcon(QIcon::fromTheme("info"));

    auto layout = new QVBoxLayout(this);

    auto btninfo = new QPushButton("info");

    layout->addWidget(btninfo);

    connect(btninfo,&QPushButton::clicked, this, &ExampleProject::onInfoClicked);
}



void ExampleProject::onInfoClicked()
{
    QMessageBox::information(this, "info", "This is some information being displayed.");

}
