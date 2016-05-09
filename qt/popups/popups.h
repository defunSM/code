#ifndef POPUPS_H
#define POPUPS_H

#include <QWidget>
#include <QMessageBox>
#include <QVBoxLayout>
#include <QPushButton>

class Popups : public QWidget
{
    Q_OBJECT

public:
    Popups(QWidget *parent = 0);
    ~Popups();

private slots:
    void onInfoClicked();
    void onCritClicked();
    void onWarnClicked();
    void onQuestionClicked();
    void onPromptClicked();
};

#endif // POPUPS_H
