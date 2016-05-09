/********************************************************************************
** Form generated from reading UI file 'pushme.ui'
**
** Created by: Qt User Interface Compiler version 5.2.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_PUSHME_H
#define UI_PUSHME_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QToolBar>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_PushMe
{
public:
    QMenuBar *menuBar;
    QToolBar *mainToolBar;
    QWidget *centralWidget;
    QStatusBar *statusBar;

    void setupUi(QMainWindow *PushMe)
    {
        if (PushMe->objectName().isEmpty())
            PushMe->setObjectName(QStringLiteral("PushMe"));
        PushMe->resize(400, 300);
        menuBar = new QMenuBar(PushMe);
        menuBar->setObjectName(QStringLiteral("menuBar"));
        PushMe->setMenuBar(menuBar);
        mainToolBar = new QToolBar(PushMe);
        mainToolBar->setObjectName(QStringLiteral("mainToolBar"));
        PushMe->addToolBar(mainToolBar);
        centralWidget = new QWidget(PushMe);
        centralWidget->setObjectName(QStringLiteral("centralWidget"));
        PushMe->setCentralWidget(centralWidget);
        statusBar = new QStatusBar(PushMe);
        statusBar->setObjectName(QStringLiteral("statusBar"));
        PushMe->setStatusBar(statusBar);

        retranslateUi(PushMe);

        QMetaObject::connectSlotsByName(PushMe);
    } // setupUi

    void retranslateUi(QMainWindow *PushMe)
    {
        PushMe->setWindowTitle(QApplication::translate("PushMe", "PushMe", 0));
    } // retranslateUi

};

namespace Ui {
    class PushMe: public Ui_PushMe {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_PUSHME_H
