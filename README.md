Ken Rodriguez
IT-633 Mobile Application Development

The Project
  An android application leveraging listviews, adapters, and custom-created objects to produce a restaurant menu
for a client, providing a useful and modular structure for the organization to create and iterate on an interactive
user interface that categorizes menu items, provides useful product information, and allows users to track the
prospective caloric value of various menu items created by the organization.

Tech Stack
  Platform - Android
  Language - Java
  UI Architecture - BaseExpandableListAdapter to support hierarchical data output
  Key Dependencies
    - androidx.appcompat for backward-compatible UI elements
    - google.android.material for modern material design 3 elements
    - constraintlayout for responsive, flexible, and widely compatible UI layouts

Key Features
  A categorized menu system was implemented via a custom MenuListAdapter that groups items on the menu
into collapsible sections. Each menu item is a custom object containing an image resource ID, a name, price,
and caloric value. The adapter programmatically sorts items into their respective categories when initialized,
ensuring that the UI stays consistent and organized regardless of the order data is sourced in. 
  Additionally, the calorie tracking feature will aggregate caloric data on a long-press of menu items, assisting health-conscious users of the application.

  A 14-page document has been included defending design patterns, evaluating alternative platforms and solutions, further
bolstering the efficacy of the project and its form within the context of the project assignment received.
