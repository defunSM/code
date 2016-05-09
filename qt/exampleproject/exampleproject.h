#ifndef EXAMPLEPROJECT_H
#define EXAMPLEPROJECT_H

#include <QtWidgets>
#include <QMessageBox>

class ExampleProject : public QWidget
{
    Q_OBJECT

public:
    ExampleProject(QWidget *parent = 0);
    ~ExampleProject();

private slots:
    void onInfoClicked();
};

#endif // EXAMPLEPROJECT_H
