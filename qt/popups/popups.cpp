#include "popups.h"

Popups::Popups(QWidget *parent)
    : QWidget(parent)
{
    resize(200, 200);
    setWindowIcon(QIcon::fromTheme("info"));


    auto layout = new QVBoxLayout(this);
    auto btnInfo = new QPushButton("Info");
    auto btnCrit = new QPushButton("Critical");
    auto btnWarn = new QPushButton("Warning");
    auto btnQuestion = new QPushButton("Question");
    auto btnPrompt = new QPushButton("What to do");

    layout->addWidget(btnInfo);
    layout->addWidget(btnCrit);
    layout->addWidget(btnWarn);
    layout->addWidget(btnQuestion);
    layout->addWidget(btnPrompt);

    connect(btnInfo, &QPushButton::clicked, this, &Popups::onInfoClicked);
    connect(btnCrit, &QPushButton::clicked, this, &Popups::onCritClicked);
    connect(btnWarn, &QPushButton::clicked, this, &Popups::onWarnClicked);
    connect(btnQuestion, &QPushButton::clicked, this, &Popups::onQuestionClicked);
    connect(btnPrompt, &QPushButton::clicked, this, &Popups::onPromptClicked);

}

Popups::~Popups()
{

}

void Popups::onInfoClicked()
{
    QMessageBox::information(this, "Info", "Displaying some info");
}

void Popups::onCritClicked()
{
    QMessageBox::critical(this, "Critical", "This is critical!");
}

void Popups::onWarnClicked()
{
    QMessageBox::warning(this, "Warning", "This is a warning...");
}

void Popups::onQuestionClicked()
{
    auto answer = QMessageBox::question(this, "Question", "Are you sure about this?");
    if (answer == QMessageBox::Yes) {
        QMessageBox::information(this, "Message", "You asked for it!");
    }
}

void Popups::onPromptClicked()
{
    auto answer = QMessageBox::critical(this, "prompt", "We are heading for a wall what should we do?", QMessageBox::Abort|QMessageBox::Ignore|QMessageBox::Help, QMessageBox::Abort);

    switch (answer) {
    case QMessageBox::Abort:
        break;
    case QMessageBox::Help:
        break;
    default:
        break;
    }
}
