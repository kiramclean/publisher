(ns publisher.layout
  (:require [publisher.login :as login]))

(defn- header []
  [:header "Publisher"])

(defn- main []
  [:main
   [:button {:on-click login/github}
    "Sign in with github"]])

(defn- footer []
  [:footer "Footer?"])

(defn app []
  [:<>
   [header]
   [main]
   [footer]])
