(ns publisher.layout
  (:require [publisher.login :as login]))

(defn- header []
  [:header "Publisher"])

(defn- main []
  [:main
   [login/github]])

(defn- footer []
  [:footer "Footer?"])

(defn app []
  [:<>
   [header]
   [main]
   [footer]])
