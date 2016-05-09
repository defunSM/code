#include "pushme.h"
#include "ui_pushme.h"

PushMe::PushMe()
{
    setText("Hello to the world!");
    setWindowTitle("PushMe");

    connect(this, &QPushButton::clicked, this, &PushMe::onClicked);
}

void PushMe::onClicked()
{
    QMessageBox::information(this, "MessageBox", "I feel so pushed.");

}
